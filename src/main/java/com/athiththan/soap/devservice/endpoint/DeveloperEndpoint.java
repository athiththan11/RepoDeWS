package com.athiththan.soap.devservice.endpoint;

import com.athiththan.soap.devservice.model.GetDeveloper;
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

    @PayloadRoot(namespace = DevServiceConstant.NAMESPACE_URI, localPart = "getDeveloper")
    @ResponsePayload
    public GetDeveloperResponse getDeveloper(@RequestPayload GetDeveloper request) {
        GetDeveloperResponse response = new GetDeveloperResponse();
        response.setDeveloper(developerRepository.findByUsername(request.getUsername()).orElseThrow(null));

        return response;
    }

    // @PayloadRoot(namespace = DevServiceConstant.NAMESPACE_URI, localPart =
    // "addDeveloper")
    // @ResponsePayload
    // public AddDeveloperResponse
}
