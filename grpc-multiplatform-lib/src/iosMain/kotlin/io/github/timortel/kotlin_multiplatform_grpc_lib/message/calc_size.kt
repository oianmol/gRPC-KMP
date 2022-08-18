package io.github.timortel.kotlin_multiplatform_grpc_lib.message

import cocoapods.Protobuf.GPBComputeRawVarint32SizeForInteger
import cocoapods.Protobuf.GPBComputeTagSize
import platform.posix.size_t

fun computeMessageSize(fieldNumber: Int, msg: KMMessage?): size_t =
    if (msg != null) {
        GPBComputeTagSize(fieldNumber) + computeMessageSizeNoTag(msg)
    } else 0u

fun computeMessageSizeNoTag(msg: KMMessage?): size_t = if (msg != null) GPBComputeRawVarint32SizeForInteger(
    msg.requiredSize.toLong()
) + msg.requiredSize else 0u
