FROM ruby:3.0.0

RUN apt-get update \
    &&  apt-get install -y \
        postgresql-client \
        vim \
        curl \
    &&  curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | apt-key add - \
    &&  echo "deb https://dl.yarnpkg.com/debian/ stable main" | tee /etc/apt/sources.list.d/yarn.list \
    &&  curl -sL https://deb.nodesource.com/setup_10.x | bash - \
    &&  apt-get update \
    &&  apt-get install -y \
    yarn \
    graphviz

RUN bundle config --global frozen 1

WORKDIR /lms

COPY Gemfile Gemfile.lock ./

RUN bundle install

COPY . .

# RUN chmod +x entrypoint.sh

# ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 3000

CMD ["rails", "server", "-b", "0.0.0.0"]

