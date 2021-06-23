package com.matricula.alumno.config;

import java.util.List;
import java.util.Random;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;


public class MyRule extends AbstractLoadBalancerRule {

//	private ILoadBalancer lb;
	
	@Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }
	
	@Override
	public Server choose(Object key) {
//        List<Server> servers = lb.getAllServers();
//        Random r = new Random();
//        int rand = r.nextInt(10);
        System.out.println("CHOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOSE");
//        if(rand > 7){
//            return getServerByPort(servers, 5555);
//        }else{
//            return getServerByPort(servers, 5555);
//        }
		List<Server> upList = getLoadBalancer().getReachableServers();
        //returns the first lb in the list every time
        if (upList != null && upList.size() > 0) {
            return upList.get(0);
        }
        return null;
	}

//	@Override
//	public void setLoadBalancer(ILoadBalancer lb) {
//		 this.lb = lb;	
//	}
//
//	@Override
//	public ILoadBalancer getLoadBalancer() {
//		  return this.lb;
//	}
	
	private Server getServerByPort(List<Server> servers, int port){
        for(Server s : servers){
            if(s.getPort() == port){
                return s;
            }
        }
        return null;
    }

}

//public class PickFirstLoadBalancerRule extends AbstractLoadBalancerRule {
//    @Override
//    public void initWithNiwsConfig(IClientConfig clientConfig) {
//
//    }
//
//    @Override
//    public Server choose(Object key) {
//
//        List<Server> upList = getLoadBalancer().getReachableServers();
//        //returns the first lb in the list every time
//        if (upList != null && upList.size() > 0) {
//            return upList.get(0);
//        }
//        return null;
//    }
//}