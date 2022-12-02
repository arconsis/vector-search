import type {Products} from "@/recommendations/rest/ProductsDto";
import axios from "axios";

const axiosClient = axios.create({baseURL: "http://localhost:3000/recommendation"})

export async function getProductsByReferenceId(productId: string): Promise<Products> {
    try {
        const result = await axiosClient.get(`/${productId}`)
        return result.data as Products
    } catch (error) {
        return {related: [], similar: []}
    }
}

export async function getProductsByReferenceImage(image: string): Promise<Products> {
    try {
        const result = await axiosClient.get(`/image`, {data: image})
        return result.data as Products
    } catch (error) {
        return {related: [], similar: []}
    }
}

