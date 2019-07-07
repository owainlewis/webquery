curl -X POST localhost:8080/api/v1/query \
-H 'Content-Type: application/json' \
-d '{"uri": "https://www.jobsite.co.uk/jobs/programming/in-cardiff?radius=20", "selector": ".job h2"}"' | jq