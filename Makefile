
package:
	./mvnw clean package

build:
	./mvnw clean spring-boot:build-image

package-jvm:
	./mvnw -f pom-jvm.xml clean package

build-jvm:
	./mvnw -f pom-jvm.xml clean spring-boot:build-image

help: ## Prints help
	@cat $(MAKEFILE_LIST) | grep -e "^[a-zA-Z_\-]*: *.*## *" | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'
