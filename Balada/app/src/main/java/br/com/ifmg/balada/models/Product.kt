package br.com.ifmg.balada.models

class Product {

    public var name: String = ""
    public var price: Double = 0.0
    public var date: String = ""
    public var entry: Int = 0

    constructor(name: String, value: Double, date: String, entry: Int){
        this.name = name
        this.price = value
        this.date = date
        this.entry = entry
    }
}