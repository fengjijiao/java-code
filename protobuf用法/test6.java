package test;

import com.google.protobuf.InvalidProtocolBufferException;

public class test6 {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println("===== 构建一个Body模型开始 =====");
        PacketProto.Packet.Content.Builder packet_content_builder = PacketProto.Packet.Content.newBuilder();
        packet_content_builder.setToID("WWWWW");
        packet_content_builder.setFromID("QQQQQ");
        packet_content_builder.setContext("hahaha");
        packet_content_builder.setFlag(2222l);
        PacketProto.Packet.Content packetContent_data = packet_content_builder.build();
        PacketProto.Packet.Body.Builder packet_body_builder = PacketProto.Packet.Body.newBuilder();
        packet_body_builder.setType(0x01);
        packet_body_builder.setAction("join");
        packet_body_builder.setContentType(PacketProto.Packet.ContentType.TEXT);
        packet_body_builder.setContent(packetContent_data);
        packet_body_builder.setTimestamp(1586486385909l);
        /*PacketProto.Packet.Builder packet_builder = PacketProto.Packet.newBuilder();
        packet_builder.s*/
        PacketProto.Packet.Body packetBody_data = packet_body_builder.build();
        System.out.println(packetBody_data.toString());
        System.out.println("===== 构建Body模型结束 =====");

        System.out.println("===== Body Byte 开始=====");
        for (byte b : packetBody_data.toByteArray()) {
            System.out.print(b+" ");
        }
        System.out.println("\n" + "bytes长度" + packetBody_data.toByteString().size());
        System.out.println("===== Body Byte 结束 =====");

        System.out.println("===== 使用Body 反序列化生成对象开始 =====");
        PacketProto.Packet.Body gd = null;
        try {
            gd = PacketProto.Packet.Body.parseFrom(packetBody_data.toByteArray());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        System.out.print(gd.toString());
        System.out.println("===== 使用Body 反序列化生成对象结束 =====");
    }
}
