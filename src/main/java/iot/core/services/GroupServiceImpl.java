package iot.core.services;

import iot.core.services.interfaces.GroupService;
import iot.presentation.transport.GroupDTO;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Created by Usera on 03/02/2017.
 */
@Service
public class GroupServiceImpl implements GroupService{

	@Override
	public GroupDTO addGroup(GroupDTO group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeGroup(long groupId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUserToGroup(long userId, long groupId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addDeviceToGroup(long deviceId, long groupId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<GroupDTO> getGroupList(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupDTO getGroupById(long groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupDTO editGroup(GroupDTO group) {
		// TODO Auto-generated method stub
		return null;
	}
}
