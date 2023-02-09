package com.jaimecorg.springprojects.tienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimecorg.springprojects.tienda.model.Group;
import com.jaimecorg.springprojects.tienda.repository.GroupRepository;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public Group updateGroup(Group group) {
        return groupRepository.save(group);
    }

    public void deleteGroup(Long groupId) {
        groupRepository.deleteById(groupId);
    }

    public Group getGroup(Long groupId) {
        return groupRepository.findById(groupId).orElse(null);
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }
}
