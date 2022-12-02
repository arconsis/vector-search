export interface Products {
    similar: Product[]
    related: Product[]
}

export interface Product {
    productId: string
    name: string
    certainty: number
    description: string
    kind: string
    image: string
}