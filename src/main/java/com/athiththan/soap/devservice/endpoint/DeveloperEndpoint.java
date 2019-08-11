package com.athiththan.soap.devservice.endpoint;

import java.util.Optional;

import com.athiththan.soap.devservice.model.AddDeveloperRequest;
import com.athiththan.soap.devservice.model.AddDeveloperResponse;
import com.athiththan.soap.devservice.model.DeleteDeveloperRequest;
import com.athiththan.soap.devservice.model.DeleteDeveloperResponse;
import com.athiththan.soap.devservice.model.Developer;
import com.athiththan.soap.devservice.model.GetDeveloperRequest;
import com.athiththan.soap.devservice.model.GetDeveloperResponse;
import com.athiththan.soap.devservice.repository.DeveloperRepository;
import com.athiththan.soap.devservice.util.DevServiceConstant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class DeveloperEndpoint {

    @Autowired
    private DeveloperRepository developerRepository;

    @PayloadRoot(namespace = DevServiceConstant.NAMESPACE_URI, localPart = "getDeveloperRequest")
    @ResponsePayload
    public GetDeveloperResponse getDeveloper(@RequestPayload GetDeveloperRequest request) {
        GetDeveloperResponse response = new GetDeveloperResponse();
        response.setDeveloper(developerRepository.findByUsername(request.getUsername()).orElseThrow(null));

        return response;
    }

    @PayloadRoot(namespace = DevServiceConstant.NAMESPACE_URI, localPart = "addDeveloperRequest")
    @ResponsePayload
    public AddDeveloperResponse addDeveloper(@RequestPayload AddDeveloperRequest request) {
        AddDeveloperResponse response = new AddDeveloperResponse();

        if (developerRepository.findByUsername(request.getUsername()).isPresent()) {
            response.setDeveloper(null);
            return response;
        }

        Developer dev = new Developer();
        dev.setUsername(request.getUsername());
        dev.setName(request.getName());
        dev.setEmail(request.getEmail());

        response.setDeveloper(developerRepository.save(dev));
        return response;
    }

    @PayloadRoot(namespace = DevServiceConstant.NAMESPACE_URI, localPart = "deleteDeveloperRequest")
    @ResponsePayload
    public DeleteDeveloperResponse deleteDeveloper(@RequestPayload DeleteDeveloperRequest request) {
        DeleteDeveloperResponse response = new DeleteDeveloperResponse();
        Optional<Developer> dev = developerRepository.findByUsername(request.getUsername());

        if (dev.isPresent()) {
            developerRepository.delete(dev.get());
            response.setMessage("Success");
        } else {
            response.setMessage("Resource not found");
        }

        return response;
    }

}
