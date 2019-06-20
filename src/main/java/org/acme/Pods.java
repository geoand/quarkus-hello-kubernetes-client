package org.acme;

import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.KubernetesClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/pods")
public class Pods {

    private final KubernetesClient kubernetesClient;

    public Pods(KubernetesClient kubernetesClient) {
        this.kubernetesClient = kubernetesClient;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{namespace}")
    public PodList pods(@PathParam("namespace") String namespace) {
        return kubernetesClient.pods().inNamespace(namespace).list();
    }
}
