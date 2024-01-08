import {expect, test} from 'vitest'
import {coinChange} from "./coin-change.js";

const denomination = [1, 5, 10, 25, 100]

test('no change means no coins', () => {
  expect(coinChange(0, denomination)).toStrictEqual({1: 0, 5: 0, 10: 0, 25: 0, 100: 0})
});

test('just return if change matches a coin value', () => {
  expect(coinChange(1, denomination)).toStrictEqual({1: 1, 5: 0, 10: 0, 25: 0, 100: 0})
  expect(coinChange(5, denomination)).toStrictEqual({1: 0, 5: 1, 10: 0, 25: 0, 100: 0})
  expect(coinChange(10, denomination)).toStrictEqual({1: 0, 5: 0, 10: 1, 25: 0, 100: 0})
  expect(coinChange(25, denomination)).toStrictEqual({1: 0, 5: 0, 10: 0, 25: 1, 100: 0})
  expect(coinChange(100, denomination)).toStrictEqual({1: 0, 5: 0, 10: 0, 25: 0, 100: 1})
})

test('acceptance', () => {
  expect(coinChange(15, denomination)).toStrictEqual({1: 0, 5: 1, 10: 1, 25: 0, 100: 0})
  expect(coinChange(40, denomination)).toStrictEqual({1: 0, 5: 1, 10: 1, 25: 1, 100: 0})
})