package iot.core.services;

import iot.core.services.interfaces.GroupService;
import iot.presentation.transport.DeviceDTO;
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
		return null;
	}

	@Override
	public boolean removeGroup(long groupId, long requesterId) {
		return false;
	}

	@Override
	public boolean addUserToGroup(long userId, long groupId, long requesterId) {
		return false;
	}

	@Override
	public boolean addDeviceToGroup(long deviceId, long groupId, long requesterId) {
		return false;
	}

	@Override
	public boolean removeDeviceFromGroup(long deviceId, long groupId, long requesterId) {
		return false;
	}

	@Override
	public boolean removeUserFromGroup(long deviceId, long groupId, long requesterId) {
		return false;
	}

	@Override
	public List<GroupDTO> getGroupList(long userId) {
		return null;
	}

	@Override
	public GroupDTO getGroupById(long groupId, long requesterId) {
		return null;
	}

	@Override
	public List<DeviceDTO> getGroupDevices(long groupId) {
		return null;
	}
}
