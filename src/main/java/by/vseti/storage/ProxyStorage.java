package by.vseti.storage;

import by.vseti.domain.Proxy;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProxyStorage {

    @Value("${path.proxy}") private String path;

    @Autowired
    private ObjectMapper mapper;

    private Iterator<Proxy> iterator;

    public Proxy getNext(){
        if (this.iterator.hasNext()){
            return this.iterator.next();
        } else {
            this.iterator = initCollection();
            return this.iterator.next();
        }
    }

    private Iterator<Proxy> initCollection(){
        try {
            return mapper
                    .readValue(new File(path), new TypeReference<List<Proxy>>(){})
                    .stream()
                    .collect(Collectors.toList())
                    .iterator();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostConstruct
    private void setUp(){
        this.iterator = initCollection();
    }
}
