package io.github.flowersbloom.udp.packet;

import io.github.flowersbloom.udp.Command;
import io.netty.buffer.ByteBuf;
import lombok.Data;

import java.util.List;

/**
 * 点对点数据报文
 */
@Data
public class P2PDataPacket extends BasePacket {
    String senderId;
    String receiverId;
    String content;

    public P2PDataPacket() {
        this.command = Command.P2P_DATA_PACKET;
    }

    @Override
    public ByteBuf toNewBuf() {
        return null;
    }

    @Override
    public List<ByteBuf> toNewBufList(long serialNumber) {
        return null;
    }
}
