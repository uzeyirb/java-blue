-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER parks_owner
WITH PASSWORD 'parks';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO parks_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO parks_owner;

CREATE USER parks_appuser
WITH PASSWORD 'parks';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO parks_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO parks_appuser;
