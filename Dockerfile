FROM selenium/standalone-chrome:3.141.59
USER root
RUN apt -qq update -y
#RUN apt install python3 python3-pip python3-pytest python3-behave -y && \
#    pip3 install pytest selenium behave
#if tests will be with firefox
#RUN apt install firefox -y
RUN apt install -qq language-pack-en language-pack-ru -y
#java and maven for tests
RUN apt install -qq openjdk-8-jdk-headless maven -y
USER seluser
WORKDIR /srv/autotests
COPY ./ ./
