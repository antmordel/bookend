.PHONY: help

help: ## Prints help
	@cat $(MAKEFILE_LIST) | grep -e "^[a-zA-Z_\-]*: *.*## *" | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

package: ## Packages the Native version
	./mvnw clean package

build: ## Builds a Native image
	./mvnw clean spring-boot:build-image

package-jvm: ## Packages the JVM version
	./mvnw -f pom-jvm.xml clean package

build-jvm: ## Builds a JVM image
	./mvnw -f pom-jvm.xml clean spring-boot:build-image

