package io.github.flowersbloom.packet;

import io.github.flowersbloom.command.BizCommand;
import io.github.flowersbloom.udp.packet.BasePacket;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 视频数据包
 */
@Data
@Slf4j
public class VideoDataPacket extends BasePacket {
    byte[] bytes;

    public VideoDataPacket() {
        this.command = BizCommand.VIDEO_DATA_PACKET;
    }

    @Override
    public List<ByteBuf> toNewBufList(long serialNumber) {
        List<ByteBuf> bufList = super.toNewBufList(serialNumber);
        for (int i = 0, sliceNum = 1; i < bytes.length; i+=DEFAULT_SLICE_LENGTH, sliceNum++) {
            int length = Math.min(bytes.length - i, DEFAULT_SLICE_LENGTH);
            byte[] raw = new byte[length];
            System.arraycopy(bytes, i, raw, 0, length);

            ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
            bufList.add(byteBuf);
            byteBuf.writeLong(this.serialNumber);
            byteBuf.writeByte(this.command);
            byteBuf.writeInt(sliceNum);
            byteBuf.writeBytes(raw);
        }
        return bufList;
    }
}
