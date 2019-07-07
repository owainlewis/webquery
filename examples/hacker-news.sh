curl -X POST localhost:8080/api/v1/query \
-H 'Content-Type: application/json' \
-d '{"uri": "https://news.ycombinator.com", "selector": ".storylink"}"' | jq
