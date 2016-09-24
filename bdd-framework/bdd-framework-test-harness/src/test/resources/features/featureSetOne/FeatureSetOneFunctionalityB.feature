#txn tag - Makes each scenario run in it's own transaction, and rolls back  between scenarios.
# FeatureSetOne tag - Feature file is a part of process/batch job one.
@txn
@FeatureSetOne
Feature: Saving users

Scenario: Adding users
Given the following users:
| Id | Name | Email       |
| 1  | Jon  | jon@fun.com |
| 2  | Ann  | ann@fun.com |
| 3  | Ray  | ray@fun.com |
When the users are saved to the system
Then the system will have the following users:
| Id | Name | Email       |
| 1  | Jon  | jon@fun.com |
| 2  | Ann  | ann@fun.com |
| 3  | Ray  | ray@fun.com |

Scenario: Adding more users
Given the following users:
| Id | Name  | Email         |
| 4  | Fred  | fred@fun.com  |
| 5  | Bread | bread@fun.com |
| 6  | Red   | red@fun.com   |
When the users are saved to the system
Then the system will have the following users:
| Id | Name | Email       |
| Id | Name  | Email         |
| 4  | Fred  | fred@fun.com  |
| 5  | Bread | bread@fun.com |
| 6  | Red   | red@fun.com   | |