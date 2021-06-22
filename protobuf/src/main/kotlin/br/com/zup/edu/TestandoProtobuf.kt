package br.com.zup.edu

import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {

    val request = FuncionarioRequest.newBuilder()
        .setNome("Yago Ramos")
        .setCpf("111.111.111-11")
        .setSalario(10000.00)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
                            .setLogradouro("Rua das Tabajaras")
                            .setCep("00000-00")
                            .setComplemento("Casa 20")
                            .build())
        .build()

    // escrevemos o objeto
    println(request)

    request.writeTo(FileOutputStream("funcionario-request.bin"))

    // lemos o objeto
    val request2 = FuncionarioRequest.newBuilder()
            .mergeFrom(FileInputStream("funcionario-request.bin"))

    request2.setCargo(Cargo.GERENTE)
        .build()

    println(request2)
}