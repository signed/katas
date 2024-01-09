import {describe, expect, test} from 'vitest'
import {closestTo0} from './closest-to-zero.js'

describe('closest to 0', () => {
  test('empty list has no element closest to zero', () => {
    expect(closestTo0([])).toEqual('no elements')
  });

  test('return single entry', () => {
    expect(closestTo0([0])).toEqual(0)
  });

  test('return positive number closest to zero', () => {
    expect(closestTo0([1, 2])).toEqual(1)
  });

  test('return negative number closest to zero', () => {
    expect(closestTo0([-1, -2])).toEqual(-1)
  });

  test('return positive number in case there are two different numbers with the same distance to zero', () => {
    expect(closestTo0([-1, 1])).toEqual(1)
  });
});

function closestToZero(_strings: string[]) {
  return 'no closest element'
}

function distanceToZero(_s: string) {
  return Number.POSITIVE_INFINITY
}

describe('closest to zero', () => {
  test('empty list does not contain a closest element', () => {
    expect(closestToZero([])).toEqual('no closest element')
  });

  test('strings that do not contain the zero characters are not close at all', () => {
    expect(distanceToZero('')).toEqual(Number.POSITIVE_INFINITY)
  });
});