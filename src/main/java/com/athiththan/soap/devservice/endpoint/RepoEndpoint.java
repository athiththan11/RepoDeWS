package com.athiththan.soap.devservice.endpoint;

import com.athiththan.soap.devservice.model.GetRepo;
import com.athiththan.soap.devservice.model.GetRepoResponse;
import com.athiththan.soap.devservice.repository.RepoRepository;
import com.athiththan.soap.devservice.util.DevServiceConstant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class RepoEndpoint {

    @Autowired
    private RepoRepository repoRepository;

    @PayloadRoot(namespace = DevServiceConstant.NAMESPACE_URI, localPart = "getRepo")
    @ResponsePayload
    public GetRepoResponse getRepo(@RequestPayload GetRepo request) {
        GetRepoResponse response = new GetRepoResponse();
        response.setRepos(repoRepository.findByUsername(request.getUsername()));

        return response;
    }

}
