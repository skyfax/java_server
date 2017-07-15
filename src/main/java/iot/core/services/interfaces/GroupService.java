package iot.core.services.interfaces;

import java.util.List;

import iot.presentation.transport.DeviceDTO;
import iot.presentation.transport.GroupDTO;

/**
 * Created by Usera on 03/02/2017.
 */
public interface GroupService {

	 GroupDTO addGroup(GroupDTO group);

	 boolean removeGroup(long groupId, long requesterId);

	 boolean addUserToGroup(long userId, long groupId, long requesterId);

	 boolean addDeviceToGroup(long deviceId, long groupId, long requesterId);

	boolean removeDeviceFromGroup(long deviceId, long groupId,  long requesterId);

	boolean removeUserFromGroup(long deviceId, long groupId, long requesterId);

	 List<GroupDTO> getGroupList(long userId);

	 GroupDTO getGroupById(long groupId,  long requesterId);

	 List<DeviceDTO> getGroupDevices(long groupId);
}
