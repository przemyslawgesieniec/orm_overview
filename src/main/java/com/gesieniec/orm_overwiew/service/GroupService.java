package com.gesieniec.orm_overwiew.service;

import com.gesieniec.orm_overwiew.dto.GroupDto;
import com.gesieniec.orm_overwiew.entity.GroupEntity;
import com.gesieniec.orm_overwiew.repository.GroupRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class GroupService {

    private GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<GroupDto> getAllGroups() {
        return groupRepository
                .findAll()
                .stream()
                .map(GroupEntity::toDto)
                .collect(Collectors.toList());
    }

    public void addGroup(GroupDto groupDto){
        GroupEntity groupEntity = new GroupEntity(groupDto.getGroupName(),groupDto.getDescription());
        groupRepository.save(groupEntity);
    }

    public void deleteGroup(String groupName) {
        final GroupEntity groupEntity = groupRepository.findByGroupName(groupName);
        groupRepository.delete(groupEntity);
    }
}
