/*
 * Find Customer Referee
 * Difficulty: Easy
 * Topic: SQL 50
 * Time complexity: O(N)
 * Space complexity: O(1)
 * Solved: 2026-09-17
 * URL: https://leetcode.com/problems/find-customer-referee/?envType=study-plan-v2&envId=top-sql-50
 *
 * Problem statement:
 * Table: Customer +-------------+---------+ | Column Name | Type | +-------------+---------+ | id | int | | name | varchar | | referee_id | int | +-------------+---------+ In SQL, id is the primary key column for this table. Each row of this table indicates the id of a customer, their name, and the id of the customer who referred them. Find the names of the customer that are either: referred by any customer with id != 2. not referred by any customer. Return the result table in any order. The result format is in the following example. Example 1: Input: Customer table: +----+------+------------+ | id | name | referee_id | +----+------+------------+ | 1 | Will | null | | 2 | Jane | null | | 3 | Alex | 2 | | 4 | Bill | null | | 5 | Zack | 1 | | 6 | Mark | 2 | +----+------+------------+ Output: +------+ | name | +------+ | Will | | Jane | | Bill | | Zack | +------+
 *
 * Notes:
 * None
 */

# Write your MySQL query statement below
SELECT name FROM Customer 
WHERE referee_id != 2 OR referee_id is NULL;
