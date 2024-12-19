package by.vseti.service;

import by.vseti.domain.Proxy;
import by.vseti.storage.ProxyStorage;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class ProxyService {

    @Autowired private ProxyStorage proxyStorage;

    private Iterator<Proxy> proxies;

    public Proxy getNext(){
        if(proxies.hasNext()){
            return proxies.next();
        } else {
            this.proxies = proxyStorage.findAll().iterator();
            return proxies.next();
        }
    }

    @PostConstruct
    private void setUp(){
        this.proxies = proxyStorage.findAll().iterator();
    }
}
