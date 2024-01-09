import {describe, expect, test} from 'vitest'
import {closestTo0, closestToZero, containsSameLettersAsZero} from './closest-to-zero.js'

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

describe('closest to zero', () => {
  test('return zero as the closest string', () => {
    expect(closestToZero(['zero'])).toEqual('zero')
  });

  test('empty list does not contain a closest element', () => {
    expect(closestToZero([])).toEqual('no closest element')
  });

  test('ignore strings that do not contain all letters', () => {
    expect(closestToZero(['bogus'])).toEqual('no closest element')
  });

  //A word is close to “zero” if it contains the same letters.
  test('detect strings that contain all characters', () => {
    expect(containsSameLettersAsZero('')).toEqual(false)
    expect(containsSameLettersAsZero('zero')).toEqual(true)
    expect(containsSameLettersAsZero('z-ero')).toEqual(true)
  });

  /*
    If more than one word contains the same letters, choose the shortest one.
    If more than one is the same length, choose the one with the letters in the most similar order.
    If there is still a tie, choose the one that appeared first in the original list.
   */
});