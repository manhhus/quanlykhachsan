/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Bill implements Serializable {
    public class ServiceCount {
            private Service service;
            private int count;
    
            public ServiceCount(Service w) {
            	service = w;
		count = 1;
            }
            public int getCount() {
		return count;
            }
            public void upCount() {
		count++;
            }
            public Service getService() {
		return service;
            }
            @Override
            public boolean equals(Object o) {
		if(o == null)
			return false;
		if( o == this)
			return true;
		if(o instanceof ServiceCount) {
			ServiceCount ow = (ServiceCount) o;
			if(ow.getService().getName().compareTo(service.getName()) == 0)
				return true;
			else
				return false;
		}	
		return false;
            }
        }
    private Room room;
    private List<Service> services;
    
    public Bill() {
        services = new LinkedList<>();
    }

    public Bill(Room room) {
        this();
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public void appendService(Service service) {
        this.services.add(service);
    }
    
    public String countService() {
        String listCount = "";
        List<ServiceCount> list = new LinkedList<>();
        for (int i = 0; i < services.size(); i++) {
            ServiceCount sc = new ServiceCount(services.get(i));
            int id = list.indexOf(sc);	
			if(id == -1) {
				list.add(sc);
			}
			else {
				list.get(id).upCount();
			}
        }
        for(ServiceCount serc : list) {
            listCount += serc.getService().getName() + " " + serc.getCount() + " " + serc.getService().getCost() + "\n";
        }
        return listCount;
    }
}
