FROM gradle:5.6.4-jdk11 AS build-env
COPY bot /bot
COPY data /data
WORKDIR /bot
RUN gradle installDist

FROM bellsoft/liberica-openjdk-alpine:11 as final
RUN adduser -S user
WORKDIR /bot
COPY --from=build-env /bot/build/install/sco-bot .
# Run under non-privileged user with minimal write permissions
USER user
ENTRYPOINT ["bin/sco-bot"]
# Expose dummy port to avoid Heroku errors
ENV PORT=8080
EXPOSE $PORT
