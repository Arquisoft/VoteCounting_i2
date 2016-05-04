#!/usr/bin/env bash
mysql -h $VOTING_DB_URL -u $VOTING_DB_USER -p$VOTING_DB_PASSWORD < startup.sql