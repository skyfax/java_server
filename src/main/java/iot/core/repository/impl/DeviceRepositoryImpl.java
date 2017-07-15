package iot.core.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import iot.core.entities.device.Device;
import iot.core.repository.DeviceRepo;

@Repository
public class DeviceRepositoryImpl implements DeviceRepo {

    @PersistenceContext
    EntityManager em;

    @Override
    public boolean addDevice(Device device) {
        em.persist(device);

        return true;
    }

    @Override
    public boolean removeDevice(long deviceId) {
        Device dev = findDeviceById(deviceId);
        Boolean result = false;

        if (dev != null) {
            em.remove(dev);
            result = true;
        }

        return result;
    }

    @Override
    public boolean editDevice(Device device) {
        em.persist(device);

        return true;
    }

    @Override
    public List<Device> getUserDevices(long userId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Device> cq = cb.createQuery(Device.class);
        Root<Device> device = cq.from(Device.class);

        cq.select(device);
        cq.where(cb.equal(device.get("ownerId"), userId));
        Query query = em.createQuery(cq);

        @SuppressWarnings("unchecked")
        List<Device> result = query.getResultList();

        return result;
    }

    @Override
    public List<Device> getGroupDevices(long groupId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Device findDeviceById(long deviceId) {
        Device device = em.find(Device.class, deviceId);
        return device;
    }

    @Override
    public Device authenticateDevice(String name, String serialNumber) {
        Device result = null;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Device> cq = cb.createQuery(Device.class);
        Root<Device> device = cq.from(Device.class);

        cq.select(device);
        cq.where(cb.equal(device.get("name"), name));
        cq.where(cb.equal(device.get("deviceSN"), serialNumber));
        Query query = em.createQuery(cq);

        try {
            result = (Device) query.getSingleResult();

        } catch (NoResultException e) {
            System.out.println("Device with name:" + name +" and SN:" + serialNumber + " notFound");
        }

        return result;
    }

}
