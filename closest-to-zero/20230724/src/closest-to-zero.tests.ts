import {describe, expect, test} from 'vitest'
import {closestToZero} from './closest-to-zero.js'

describe('closest to 0', () => {
  test('empty list has no element closest to zero', () => {
    expect(closestToZero([])).toEqual('no elements')
  });

  test('return single entry', () => {
    expect(closestToZero([0])).toEqual(0)
  });

  test('return positive number closest to zero', () => {
    expect(closestToZero([1, 2])).toEqual(1)
  });

  test('return negative number closest to zero', () => {
    expect(closestToZero([-1, -2])).toEqual(-1)
  });

  test('return positive number in case there are two different numbers with the same distance to zero', () => {
    expect(closestToZero([-1, 1])).toEqual(1)
  });
});