import {expect, test} from 'vitest'
import {closestToZero} from './closest-to-zero.js'

test('empty list has no element closest to zero', () => {
  expect(closestToZero([])).toEqual('no elements')
});

test('return single entry', () => {
  expect(closestToZero([0])).toEqual(0)
});