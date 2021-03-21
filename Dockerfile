FROM gradle:jdk11-hotspot AS build-env
COPY . /app
WORKDIR /app
RUN gradle installDist

FROM bellsoft/liberica-openjdk-alpine:11 as final
RUN adduser -S user
WORKDIR /app
COPY --from=build-env /app/build/install/sco-bot .
# Run under non-privileged user with minimal write permissions
USER user
ENTRYPOINT ["bin/sco-bot"]
# Expose dummy port to avoid Heroku errors
ENV PORT=80
EXPOSE $PORT
