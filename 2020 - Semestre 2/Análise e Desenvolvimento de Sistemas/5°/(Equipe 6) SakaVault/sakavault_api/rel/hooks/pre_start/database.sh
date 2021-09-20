#!/bin/bash

/opt/app/bin/sakavault eval "Elixir.SakaVault.ReleaseTasks.create_database()"
/opt/app/bin/sakavault eval "Elixir.SakaVault.ReleaseTasks.migrate_database()"
