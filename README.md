# bms-clone

Issues faced during development : 

1. Jackson JSON infinite recursion problem with bidirectional relationships

```
[
    {
        "cityId": 1,
        "name": "New Delhi",
        "theatreList": [
            {
                "id": 1,
                "name": "Janak Cinema",
                "city": {
                    "cityId": 1,
                    "name": "New Delhi",
                    "theatreList": [
                        {
                            "id": 1,
                            "name": "Janak Cinema",
                            "city": {
                                "cityId": 1,
                                "name": "New Delhi",
                                "theatreList": [
                                    {
                                        "id": 1,
                                        "name": "Janak Cinema",
                                        "city": {
                                            "cityId": 1,
                                            "name": "New Delhi",
                                            ....
```

Resolution : A design decision was made of making the 1:N relationship between CITY and THEATRE from bidirectional to unidirectional since the theatres need don't need the attributes from CITY.

2. Keeping reserved keyword names as Table name (Sounds trivial but caused a lot oh headache)

The following error was being logged : 
> Could not write JSON: JDBC exception executing SQL [select sl1_0.hall_id,sl1_0.id from show sl1_0 where sl1_0.hall_id=?] [You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'show sl1_0 where sl1_0.hall_id=1' at line 1] [n/a]]

### Resolution

The issue was related to a SQL syntax issue in the query. So, Hibernate was attempting to fetch data from the ***Show*** entity. The problem lied in the name of the table "SHOW", which conflicted with the reserved keyword in MySQL.

MySQL uses ***"SHOW"*** as a reserved keyword for various operations such as showing databases, tables, etc. Therefore, when Hibernate generated the SQL query, it was interpreting "SHOW" as the reserved keyword rather than the name of the entity table.

Therefore, renamed the table to ***SHOWS***