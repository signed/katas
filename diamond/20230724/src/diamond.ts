export function diamond(character: string) {
  return diamondLinesFor(character).join('\n')
}

function diamondLinesFor(character: string) {
  const verticalBlueprint = horizontalBlueprintFor(character)
  return verticalBlueprintFor(character).map((vertical) => {
    const line = verticalBlueprint.map((horizontal) => {
      return horizontal === vertical ? horizontal : ' '
    })
    return line.join('')
  })
}

export function horizontalBlueprintFor(character: string) {
  const left = includedCharactersFor(character).reverse()
  const right = includedCharactersFor(character)
  right.shift()

  return [...left, ...right]
}

export function verticalBlueprintFor(character: string) {
  const top = includedCharactersFor(character)
  const bottom = includedCharactersFor(character).reverse()
  bottom.shift()
  return [...top, ...bottom]
}

export function includedCharactersFor(character: string) {
  const start = character.charCodeAt(0)
  const last = 'A'.charCodeAt(0)
  const included = []
  for (let i = start; i >= last; i--) {
    included.unshift(i)
  }
  return included.map((codepoint) => String.fromCharCode(codepoint))
}
