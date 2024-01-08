import { expect, test } from 'vitest'
import { horizontalBlueprintFor, diamond, includedCharactersFor, verticalBlueprintFor } from './diamond'

test('explore api', () => {
  expect('A'.charCodeAt(0)).toEqual(65)
  expect('B'.charCodeAt(0)).toEqual(66)
  expect('Z'.charCodeAt(0)).toEqual(90)
})

test('determine included characters', () => {
  expect(includedCharactersFor('A')).toEqual(['A'])
  expect(includedCharactersFor('B')).toEqual(['A', 'B'])
  expect(includedCharactersFor('D')).toEqual(['A', 'B', 'C', 'D'])
})

test('generate horizontal blue print', () => {
  expect(horizontalBlueprintFor('A')).toEqual(['A'])
  expect(horizontalBlueprintFor('B')).toEqual('BAB'.split(''))
  expect(horizontalBlueprintFor('D')).toEqual('DCBABCD'.split(''))
})

test('generate vertical blue print', () => {
  expect(verticalBlueprintFor('A')).toEqual(['A'])
  expect(verticalBlueprintFor('B')).toEqual('ABA'.split(''))
  expect(verticalBlueprintFor('C')).toEqual('ABCBA'.split(''))
})

test('Akzeptanztest', () => {
  const result = diamond('A')

  expect(result).toEqual('A')
})

test('B diamond', () => {
  const result = diamond('B')

  expect(result).toEqual(' A \nB B\n A ')
})

test('C diamond', () => {
  const result = diamond('C')
  // prettier-ignore
  const expected = [
    ['  A  '],
    [' B B '],
    ['C   C'],
    [' B B '],
    ['  A  '],
  ]
  expect(result).toEqual(expected.join('\n'))
})

test('C diamond', () => {
  const result = diamond('D')
  // prettier-ignore
  const expected = [
    ['   A   '],
    ['  B B  '],
    [' C   C '],
    ['D     D'],
    [' C   C '],
    ['  B B  '],
    ['   A   '],
  ]
  expect(result).toEqual(expected.join('\n'))
})
