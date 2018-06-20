package com.muy.admin.service;

import com.google.common.collect.Lists;
import com.muy.admin.model.domain.GroupRoleDO;
import com.muy.admin.model.domain.MasterGroupDO;
import com.muy.admin.model.domain.MasterRoleDO;
import com.muy.admin.model.query.DeleteGroupRoleQuery;
import com.muy.admin.model.query.SaveGroupRoleQuery;
import com.muy.admin.model.vo.CascaderVO;
import com.muy.admin.repository.GroupRoleRepository;
import com.muy.admin.repository.MasterGroupRepository;
import com.muy.admin.repository.MasterRoleRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yanglikai on 2018/5/24.
 */
@Service
public class GroupRoleService {
  @Resource
  private GroupRoleRepository groupRoleRepository;
  @Resource
  private MasterGroupRepository groupRepository;
  @Resource
  private MasterRoleRepository roleRepository;

  /**
   * 保存/更新组织角色信息.
   *
   * @param query
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  public boolean save(SaveGroupRoleQuery query) {
    String groupCode = query.getGroupCode();

    List<GroupRoleDO> target = parse(query);
    groupRoleRepository.delete(groupCode);
    groupRoleRepository.save(target);
    return true;
  }

  /**
   * 批量保存/更新组织角色信息.
   *
   * @param query
   * @return
   */
  public boolean save(List<SaveGroupRoleQuery> query) {
    List<GroupRoleDO> target = Lists.newArrayList();

    for (SaveGroupRoleQuery item : query) {
      target.addAll(parse(item));
    }

    return groupRoleRepository.save(target);
  }

  private List<GroupRoleDO> parse(SaveGroupRoleQuery query) {
    String groupCode = query.getGroupCode();

    List<String> roles = query.getRoles();

    List<GroupRoleDO> target = Lists.newArrayListWithCapacity(roles.size());
    for (String role : roles) {
      GroupRoleDO entity = new GroupRoleDO();
      entity.setPkey(groupCode + "|" + role);
      entity.setGroupCode(groupCode);
      entity.setRoleCode(role);

      target.add(entity);
    }

    return target;
  }

  /**
   * 删除组织角色信息.
   *
   * @param query
   * @return
   */
  public boolean delete(DeleteGroupRoleQuery query) {
    return groupRoleRepository.delete(query.getGroupCode());
  }

  /**
   * 加载指定组织下角色信息.
   *
   * @param groupCode
   * @return
   */
  public List<GroupRoleDO> load(String groupCode) {
    return groupRoleRepository.selectByGroupCode(groupCode);
  }

  /**
   * 加载所有组织角色信息.
   *
   * @return
   */
  public List<GroupRoleDO> loadAll() {
    return groupRoleRepository.selectAll();
  }

  /**
   * 级联加载.
   *
   * @return
   */
  public List<CascaderVO> loadCascader() {
    /* KeyValue */
    Map<String, String> groupMapping = keyValue4Group();
    Map<String, String> roleMapping = keyValue4Role();

    /* 分组 */
    List<GroupRoleDO> groupRoleAll = groupRoleRepository.selectAll();
    Map<String, List<GroupRoleDO>> group =
        groupRoleAll.stream()
            .collect(Collectors.groupingBy(GroupRoleDO::getGroupCode));

    List<CascaderVO> result = Lists.newArrayListWithCapacity(group.size());

    for (Map.Entry<String, List<GroupRoleDO>> entry : group.entrySet()) {
      String gCode = entry.getKey();
      String gName = groupMapping.get(gCode);
      List<GroupRoleDO> value = entry.getValue();

      List<CascaderVO> childrens = Lists.newArrayListWithCapacity(value.size());
      for (GroupRoleDO item : value) {
        String rCode = item.getRoleCode();
        String rName = roleMapping.get(rCode);
        CascaderVO children =
            CascaderVO.builder()
                .id(rCode)
                .pid(gCode)
                .value(rCode)
                .label(rName)
                .build();

        childrens.add(children);
      }

      CascaderVO parent =
          CascaderVO.builder()
              .id(gCode)
              .value(gCode)
              .label(gName)
              .children(childrens)
              .build();

      result.add(parent);
    }

    return result;
  }

  public Map<String, String> keyValue4Group() {
    List<MasterGroupDO> groupAll = groupRepository.selectAll();

    Map<String, String> mapping = new HashMap<>(groupAll.size());
    groupAll.forEach(item -> {
      mapping.put(item.getCode(), item.getName());
    });

    return mapping;
  }

  public Map<String, String> keyValue4Role() {
    List<MasterRoleDO> roleAll = roleRepository.selectAll();

    Map<String, String> mapping = new HashMap<>(roleAll.size());
    roleAll.forEach(item -> {
      mapping.put(item.getCode(), item.getName());
    });

    return mapping;
  }
}
