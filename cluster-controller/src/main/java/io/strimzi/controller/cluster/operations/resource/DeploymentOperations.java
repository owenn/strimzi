/*
 * Copyright 2017-2018, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.controller.cluster.operations.resource;

import io.fabric8.kubernetes.api.model.extensions.Deployment;
import io.fabric8.kubernetes.api.model.extensions.DeploymentList;
import io.fabric8.kubernetes.api.model.extensions.DoneableDeployment;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.ScalableResource;
import io.vertx.core.Vertx;

/**
 * Operations for {@code Deployment}s.
 */
public class DeploymentOperations extends AbstractScalableOperations<KubernetesClient, Deployment, DeploymentList, DoneableDeployment, ScalableResource<Deployment, DoneableDeployment>> {
    /**
     * Constructor
     * @param vertx The Vertx instance
     * @param client The Kubernetes client
     */
    public DeploymentOperations(Vertx vertx, KubernetesClient client) {
        super(vertx, client, "Deployment");
    }

    @Override
    protected MixedOperation<Deployment, DeploymentList, DoneableDeployment, ScalableResource<Deployment, DoneableDeployment>> operation() {
        return client.extensions().deployments();
    }
}
