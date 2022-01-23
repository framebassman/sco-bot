FROM gradle:5.6.4-jdk11 AS build-env
COPY . /ash
WORKDIR /ash/application/bot
RUN gradle installDist

FROM bellsoft/liberica-openjdk-alpine:11 as final
RUN adduser -S user
WORKDIR /bot
COPY --from=build-env /ash/application/bot/build/install/bot .
# Run under non-privileged user with minimal write permissions
USER user
ENTRYPOINT ["bin/bot"]
# Expose dummy port to avoid Heroku errors
ENV PORT=8080
EXPOSE $PORT
