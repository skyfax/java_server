package iot.core.services.interfaces;

import java.util.List;

import iot.presentation.transport.GroupDTO;

/**
 * Created by Usera on 03/02/2017.
 */
public interface GroupService {

	public GroupDTO addGroup(GroupDTO group);

	public boolean removeGroup(long groupId);

	public boolean addUserToGroup(long userId, long groupId);

	public boolean addDeviceToGroup(long deviceId, long groupId);

	public List<GroupDTO> getGroupList(long userId);

	public GroupDTO getGroupById(long groupId);

	public GroupDTO editGroup(GroupDTO group);
}
