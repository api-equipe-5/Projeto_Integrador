# builds all dependencies
#
FROM elixir:alpine AS builder

ENV LANG C.UTF-8
ENV MIX_ENV prod
ENV REPLACE_OS_VARS true

RUN apk upgrade --no-cache \
      && apk add --no-cache build-base gcc git make musl-dev \
      && mix local.hex --force \
      && mix local.rebar --force

WORKDIR /app
COPY mix.* /app/

RUN mix deps.get --only=prod && mix deps.compile

# release the app
#
FROM builder AS releaser

ARG COOKIE
ENV COOKIE ${COOKIE}

COPY . /app/

RUN mix distillery.release --env=prod

# mininum runner environment
#
FROM alpine:3.9 AS runner

RUN apk upgrade --no-cache \
      && apk add --update --no-cache bash curl openssl-dev

# fix for heroku containers
RUN rm /bin/sh && ln -s /bin/bash /bin/sh

WORKDIR /opt/app
COPY --from=releaser /app/_build/prod/rel/sakavault /opt/app/

# runtime
#
FROM runner AS runtime

ENV MIX_ENV prod
EXPOSE 4000

ENTRYPOINT ["bin/sakavault"]
CMD ["foreground"]
