FROM openjdk:17

WORKDIR /app

RUN curl -Ls https://sh.jbang.dev | bash -s - app setup

CMD ["tail", "-f", "/dev/null"]