#!/bin/sh
curl -XPUT 'http://localhost:9200/techniques/technique/1' -d '{
    "name" : "technique1"
}'
curl -XPUT 'http://localhost:9200/techniques/technique/2' -d '{
    "name" : "technique2"
}'
curl -XPUT 'http://localhost:9200/techniques/technique/3' -d '{
    "name" : "technique3"
}'
curl -XPUT 'http://localhost:9200/techniques/technique/4' -d '{
    "name" : "technique4"
}'
curl -XPUT 'http://localhost:9200/techniques/technique/5' -d '{
    "name" : "technique5"
}'