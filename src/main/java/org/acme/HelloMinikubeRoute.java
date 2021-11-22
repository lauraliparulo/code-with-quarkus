package org.acme;

import org.apache.camel.builder.RouteBuilder;

public class HelloMinikubeRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		rest("/helloMinikube").get().route().routeId("k8s-hello-minikube").log("Request Received.")
				.setBody(constant("Hello from minikube.")).to("micrometer:counter:hello.counter")
				.to("micrometer:timer:hello.timer").endRest();

	}
}
