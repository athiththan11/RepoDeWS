package com.athiththan.soap.devservice.endpoint;

import com.athiththan.soap.devservice.model.AddRepoRequest;
import com.athiththan.soap.devservice.model.AddRepoResponse;
import com.athiththan.soap.devservice.model.GetRepoRequest;
import com.athiththan.soap.devservice.model.GetRepoResponse;
import com.athiththan.soap.devservice.model.Repo;
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

    @PayloadRoot(namespace = DevServiceConstant.NAMESPACE_URI, localPart = "getRepoRequest")
    @ResponsePayload
    public GetRepoResponse getRepo(@RequestPayload GetRepoRequest request) {
        GetRepoResponse response = new GetRepoResponse();
        response.setRepos(repoRepository.findByUsername(request.getUsername()));

        return response;
    }

    @PayloadRoot(namespace = DevServiceConstant.NAMESPACE_URI, localPart = "addRepoRequest")
    @ResponsePayload
    public AddRepoResponse addRepo(@RequestPayload AddRepoRequest request) {
        AddRepoResponse response = new AddRepoResponse();

        Repo repo = new Repo();
        repo.setUsername(request.getUsername());
        repo.setName(request.getName());
        repo.setForks(request.getForks());

        response.setRepo(repoRepository.save(repo));
        return response;
    }

}
